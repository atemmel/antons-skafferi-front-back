import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  image: any;
  test: boolean = true;

  imageName: string = 'restaurant_1920x1280.jpg';
  constructor() { }


  ngOnInit() {
  }

}
