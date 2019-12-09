import {Component, OnInit, Input, ViewChild} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {GetTabelsService} from '../services/data/get-tabels.service';
import {ErrorStateMatcher} from '@angular/material';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }

}




@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.scss']
})
export class BookingComponent implements OnInit {
  @Input() showMePartially: boolean;
  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  nameFormControl = new FormControl('', [
    Validators.required,
    ]);
  lastNameFormControl = new FormControl('', [
    Validators.required,
  ]);

  phoneFormControl = new FormControl('', [
    Validators.required,
  ]);

  amountFormControl = new FormControl('', [
    Validators.required,
  ]);

  geturl = 'http://localhost:8080/customers';
  posturl = 'http://localhost:8080/post/customers?customer=';
  items = [];
  tables: Array<Table> = [];
  tableResp: any;
  tablesLoaded: Promise<boolean>;
  clickMessage = '';
  public customerFirstName = "";
  public customerLastName = "";
  public customerEmail = "";
  public bookingDate = "";
  public booingTime = "";
  public sizeOfCompany = "";
  public customerPhone = "";
  postData = {
    bookingdate: "",
    bookingtime: "",
    firstname: "",
    lastname: "",
    email: "",
    phone: "",
    sizeofcompany: "",
    dinnertable: 1,
  };

  constructor(private http: HttpClient, private tableGetter: GetTabelsService) {
    this.http.get(this.geturl).subscribe(data => {

      for (const key in data) {
        if (data.hasOwnProperty(key)) {
          this.items.push(data[key]);
        }
      }
    });
  }

  reload() {
    window.location.reload();
  }


  onClickMe() {
    this.clickMessage = "Please fill all information";
    if (this.customerFirstName !== "" && this.customerLastName !== "" && this.customerPhone !== "" &&
      !this.emailFormControl.hasError('email') && !this.emailFormControl.hasError('required') && this.sizeOfCompany !== "") {
      this.postData.firstname = this.customerFirstName;
      // console.log(this.postData.firstname);
      this.postData.lastname = this.customerLastName;
      this.postData.email = this.customerEmail;
      this.postData.phone = this.customerPhone;
      this.postData.sizeofcompany = this.sizeOfCompany;

      console.log(this.postData);


      this.clickMessage = "Thanks for reservation";


      this.http.post(this.posturl, this.postData).subscribe((data: any) => {
        });
      this.postData.bookingdate = "";
      this.postData.bookingtime = "";
      this.postData.dinnertable = null;
      this.postData.email = "";
      this.postData.firstname = "";
      this.postData.lastname = "";
      this.postData.phone = "";
      this.postData.sizeofcompany = "";
      (document.getElementById("form") as HTMLInputElement).style.display = "none";
      (document.getElementById("done") as HTMLInputElement).style.display = "block";

      } else {
      (document.getElementById("errorText") as HTMLInputElement).innerHTML = "Var vänlig fyll i alla fält";
      (document.getElementById("errorText") as HTMLInputElement).style.display = "block";
    }


  }

  ngOnInit() {
    (document.getElementById("button") as HTMLInputElement).style.display = "none";
    (document.getElementById("noTables") as HTMLInputElement).style.display = "none";
    (document.getElementById("errorText") as HTMLInputElement).style.display = "none";
    (document.getElementById("mainForm") as HTMLInputElement).style.display = "none";
    (document.getElementById("done") as HTMLInputElement).style.display = "none";
  }

  async dateChange(event: any) {
    this.tables = Array<Table>();
    const data: Date = event;
    const formatedDate: string = data.getFullYear() + '-' + (data.getMonth() + 1 ) + '-' + data.getDate();
    console.log(formatedDate);

    const resp = await this.tableGetter.getTabels(formatedDate).toPromise();
    this.tableResp = resp;
    this.tablesLoaded = Promise.resolve(true);

    this.tableResp.forEach(val => {
      const temp: Table = val;
      this.tables.push(temp);
    });

    console.log(this.tables);

    if (this.tables.length === 0) {
      (document.getElementById("noTables") as HTMLInputElement).style.display = "block";
    } else {
      this.postData.bookingdate = formatedDate;

    }
  }

  timeChange(event: any) {
    const data = event.toString();
    console.log(event.toString());
    if (data !== "Välj Tid") {
      (document.getElementById("mainForm") as HTMLInputElement).style.display = "flex";
      this.postData.bookingtime = data;
    } else {
      (document.getElementById("mainForm") as HTMLInputElement).style.display = "none";
    }

  }

  amountChange(event: any) {
    console.log(event);
    console.log(typeof event);
    (document.getElementById("errorText") as HTMLInputElement).style.display = "none";
    (document.getElementById("button") as HTMLInputElement).style.display = "none";
    if (event === "") {
      return;
    }
    const amount: number = Number(event);
    let tableToSit: Table = null;
    if (amount === 0) {
      (document.getElementById("errorText") as HTMLInputElement).innerHTML = "Du kan inte boka bord för 0 personer";
      (document.getElementById("errorText") as HTMLInputElement).style.display = "block";
      return;
    } else if (amount > 0 && amount < 5) {
      tableToSit = this.tables.find((x => x.sizeOfTable === 4));
      if (tableToSit == null) {
        tableToSit = this.tables.find((x => x.sizeOfTable === 6));
      }
    } else if (amount > 4 && amount < 7) {
      tableToSit = this.tables.find((x => x.sizeOfTable === 6));
    } else {
      (document.getElementById("errorText") as HTMLInputElement).innerHTML = "För sällskap större än 6 var vänlig ring resturangen";
      (document.getElementById("errorText") as HTMLInputElement).style.display = "block";
      return;
    }

    if (tableToSit != null) {
      this.postData.dinnertable = tableToSit.dinnertableid;
      (document.getElementById("button") as HTMLInputElement).style.display = "block";
    } else {
      (document.getElementById("errorText") as HTMLInputElement).innerHTML = "Det fanns inget tillgänglit bord som passar storleken" +
        " på ert sällskap. Ni kan kontakta resturangen för att se om det går att lösa endå";
      (document.getElementById("errorText") as HTMLInputElement).style.display = "block";
    }
  }
}


class Table {
  dinnertableid: number;
  description: string;
  sizeOfTable: number;

  constructor(dinnertableid: number, description: string, sizeOfTable: number) {
    this.dinnertableid = dinnertableid;
    this.description = description;
    this.sizeOfTable = sizeOfTable;
  }

}
