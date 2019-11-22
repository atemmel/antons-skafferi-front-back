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

  constructor(private service: GetImageService, private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.getMenu();
    this.getImage();
  }

  getImage() {
    this.service.getImage(this.folderName, this.imageName).subscribe(data => {
      // Tells angular that the link and the data is safe.
      this.image = this.sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + data);

    }, error => {
      console.log(error);
    });
  }

  getMenu() {
    let menuObject: Object;
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
