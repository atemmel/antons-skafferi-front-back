import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  image: any;
  imageBase64: any;
  newStyle = 'background-image: url("data:image/jpg;base64,' + this.image + '")';
  imageName: string = 'restaurant_1920x1280.jpg';
  constructor() { }


  ngOnInit() {

  }

}
