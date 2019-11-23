import { Component, OnInit } from '@angular/core';
import {GetImageService} from '../services/data/get-image.service';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-dinner',
  templateUrl: './dinner.component.html',
  styleUrls: ['./dinner.component.scss']
})
export class DinnerComponent implements OnInit {

  menu: any;
  image: any;
  imageName: string = "reindeerstew.jpg";
  folderName: string = "website";

  constructor() { }

  ngOnInit() {
    this.getMenu();
  }


  getMenu() {
    let menuObject: object;
    menuObject = {
      chefsChoice: ["Vildssvin", "Vild lax", "Ren"],
      starters: ["Skagen toast", "Vtilöksbröd", "Tatar", "Mozarella pinnar"],
      vilt: ["Renskav", "Älgstek", "Bäver"],
      aLaCarte: ["Lax", "oxfilè"]

    };

    this.menu = menuObject;

    console.log(menuObject);


    }

  }
