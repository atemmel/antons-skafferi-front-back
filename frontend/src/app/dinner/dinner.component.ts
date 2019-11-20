import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dinner',
  templateUrl: './dinner.component.html',
  styleUrls: ['./dinner.component.scss']
})
export class DinnerComponent implements OnInit {

  menu: any;

  constructor() { }

  ngOnInit() {
    this.getMenu();
  }

  getMenu() {
    let menuObject: Object;
    menuObject = {
      starters: ["Skagen toast", "Vtilöksbröd", "Tatar", "Mozarella pinnar"],
      vilt: ["Renskav", "Älgstek", "Bäver"],
      aLaCarte: ["Lax", "oxfilè"]

    };

    this.menu = menuObject;

    console.log(menuObject);


    }

  }
