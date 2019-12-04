import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TouchSequence } from 'selenium-webdriver';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.scss']
})
export class BookingComponent implements OnInit {
  @Input() showMePartially: boolean;

  geturl = 'http://localhost:8080/customers';
  posturl = 'http://localhost:8080/post/customers?customer=';
  items = [];
  json;
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
  };

  constructor(private http: HttpClient) {
    this.http.get(this.geturl).subscribe(data => {

      for (const key in data) {
        if (data.hasOwnProperty(key)) {
          this.items.push(data[key]);
        }
      }
    });
  }


  // https://www.npmjs.com/package/angular2-datetimepicker
  date: Date = new Date();
  settings = {
    bigBanner: true,
    timePicker: true,
    format : 'yyyy-MM-dd hh:mm',
    defaultOpen: false,
    closeOnSelect: false

  };

  // Pads a leading 0 for single digit numbers
  padDigit(num: number) {
    return num < 10  ? '0' + String(num) : num;
  }


  onClickMe() {
    this.clickMessage = "Please fill all information";
    if (this.customerFirstName !== "" && this.customerLastName !== "" && this.customerPhone !== "" && this.customerEmail !== "" && this.sizeOfCompany !== "") {
      this.postData.firstname = this.customerFirstName;
      //console.log(this.postData.firstname);
      this.postData.lastname = this.customerLastName;
      this.postData.email = this.customerEmail;
      this.postData.phone = this.customerPhone;
      this.postData.sizeofcompany = this.sizeOfCompany;

      console.log(this.postData);


      this.clickMessage = "Thanks for reservation";


      this.http.post(this.posturl, this.postData).subscribe((data: any) => {
        });

      }
  }

  ngOnInit() {
  }

  dateChange(event: any) {
    const data = event;
    const formatedDate: string = data.getFullYear() + '-' + (data.getMonth() + 1 ) + '-' + data.getDate();
    console.log(formatedDate);
    this.postData.bookingdate = formatedDate;

  }

  timeChange(event: any) {
    const data = event.toString();
    console.log(event.toString());
    if (data !== "Välj Tid") {
      this.postData.bookingtime = data;
    }

  }

}
