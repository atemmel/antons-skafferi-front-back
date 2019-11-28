import { Component, OnInit } from '@angular/core';
import { GetImageService } from '../services/data/get-image.service';
import { DomSanitizer } from '@angular/platform-browser';
import { getLocaleDayNames } from '@angular/common';

@Component({
  selector: 'app-lunch',
  templateUrl: './lunch.component.html',
  styleUrls: ['./lunch.component.scss']
})
export class LunchComponent implements OnInit {

  lunchMeals: any;
  dailyLunch: any;
  days: any[] = [[], [], [], [], []];
  image: any;
  imageName: string = "restaurant_1920x1280.jpg";
  folderName: string = "website";

  constructor(private service: GetImageService, private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.getLunchMenu();
    this.getDailyLunch();
  }

  getDailyLunch() {
    const date: number = (new Date().getDay());
    this.dailyLunch = this.lunchMeals.filter(meal => meal.day == date)
    //console.log(this.dailyLunch);
  }

  getLunchMenu() {

    // 0 is sunday, 1 is monday, 2 is tuesday, 3 is wednesday, 4 is thursday, 5 is friday, 6 is saturday
    this.lunchMeals = [
      {
        "mealName": "Grön Sparrissoppa",
        "day": 5,
        "type": "Vegetariskt"
      },
      {
        "mealName": "Panerad rödspetta med skagenröra",
        "day": 5,
        "type": "Fisk"
      },
      {
        "mealName": "Kycklingfilé med champinjonsås och stekt potatis",
        "day": 5,
        "type": "För Köttälskare"
      },
      {
        "mealName": "Lax & spenatsoppa",
        "day": 1,
        "type": "Fisk"
      },
      {
        "mealName": "Spagetti bolognaise",
        "day": 2,
        "type": "Dagens Pasta"
      },
      {
        "mealName": "Stekt fläsk med löksås",
        "day": 3,
        "type": "För köttälskare"
      },
      {
        "mealName": "Clam Showder på 'Antons vis' med aioli",
        "day": 4,
        "type": "Fisk"

      },
      {
        "mealName": "Örtbakad torskfilé med gratinerad potatismos",
        "day": 2,
        "type": "Fisk"
      },
      {
        "mealName": "Pastagratäng med rökt kassler purjolök och cocktailtomater",
        "day": 3,
        "type": "Pastarätt"
      },
      {
        "mealName": "Ärtsoppa med pannkakor, grädde & sylt",
        "day": 5,
        "type": "Klassiker"
      },
      {
        "mealName": "Laxpudding med skirat smör och lingonsylt",
        "day": 4,
        "type": "Fisk"
      },
      {
        "mealName": "Kalops på högrev kokt potatis och rödbetor",
        "day": 4,
        "type": "Kötträtt"
      },
      {
        "mealName": "Köttfärsås och spaghetti",
        "day": 2,
        "type": "Kött"
      },
      {
        "mealName": "Fish and chips med remouladsås",
        "day": 3,
        "type": "Fiskrätt"
      },
      {
        "mealName": "Stek",
        "day": 1,
        "type": "Kötträtt"
      }
    ];

    /**Sorts every individual day so that they're all ordered after type alphabetically*/
    for(var i = 0; i < this.days.length; i++) {
      this.days[i] = this.lunchMeals.filter(meal => meal.day == i + 1);
      this.days[i].sort((lhs, rhs) => {
        var lhsType = lhs.type.toUpperCase();
        var rhsType = rhs.type.toUpperCase();

        if (lhsType < rhsType) {
          return -1;
        }
        if (lhsType > rhsType) {
          return 1;
        }
        return 0;
      });
    }
  }
}
