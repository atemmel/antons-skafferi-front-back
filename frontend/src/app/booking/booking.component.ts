import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.scss']
})
export class BookingComponent implements OnInit {

  
  url = 'http://localhost:8080/customers/';
  items = [];
  json;
  clickMessage = '';
  public customerName ='';
  public customerEmail= '';
  public bookingDate = "dateTime";
  postData = { 
    "bookingDateTime": "",
    "name": "",
    "email": ""
  };

  constructor(private http: HttpClient){
    this.http.get(this.url).toPromise().then(data => {
      console.log(data);

      for (let key in data)
        if(data.hasOwnProperty(key))
          this.items.push(data[key]);
    });
  }
 

  //https://www.npmjs.com/package/angular2-datetimepicker
  date : Date = new Date();
  settings = {
    bigBanner: true,
    timePicker: true,
    format : 'yyyy-MM-dd hh:mm',
    defaultOpen: false,
    closeOnSelect: false

  }

  //Pads a leading 0 for single digit numbers
  padDigit(num : number) {
    return num < 10  ? '0' + String(num) : num;
  }

  //Builds the appropriate
  buildDate(date : Date) {
    return this.padDigit((date.getUTCFullYear())) + '-' + this.padDigit(date.getMonth() + 1) 
      + '-' + this.padDigit(date.getDate()) + ' ' + this.padDigit(date.getHours()) 
      + ':' + this.padDigit(date.getMinutes());
  }

  onClickMe() {
    this.postData.name = this.customerName;
    this.postData.email = this.customerEmail;
    console.log(this.date);
    this.postData.bookingDateTime = this.buildDate(new Date(this.date)); 
    this.clickMessage = this.postData.bookingDateTime;
    this.http.post(this.url, this.postData).toPromise().then((data:any) =>{
      console.log(data);
      this.json = JSON.stringify(data.json);
    });
  }

  ngOnInit() {
  }

}
