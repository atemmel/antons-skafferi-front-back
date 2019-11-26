import { Component, OnInit } from '@angular/core';
import { GetImageService } from '../services/data/get-image.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-lunch',
  templateUrl: './lunch.component.html',
  styleUrls: ['./lunch.component.scss']
})
export class LunchComponent implements OnInit {

  lunchMeals: any;
  days: any[] = [[], [], [], [], []];
  image: any;
  imageName: string = "restaurant_1920x1280.jpg";
  folderName: string = "website";

  constructor(private service: GetImageService, private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.getLunchMenu();
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

  getLunchMenu() { 

    this.lunchMeals = [
      {
        "mealName": "Grön Sparrissoppa",
        "day": 0,
        "type": "Vegetariskt"
      },
      {
        "mealName": "Panerad rödspetta med skagenröra",
        "day": 0,
        "type": "Fisk"
      },
      {
        "mealName": "Kycklingfilé med champinjonsås och stekt potatis",
        "day": 0,
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
        "day": 0,
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
      this.days[i] = this.lunchMeals.filter(meal => meal.day == i);
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
