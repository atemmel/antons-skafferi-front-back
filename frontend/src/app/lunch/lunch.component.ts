import { Component, OnInit } from '@angular/core';
import { getLocaleDayNames } from '@angular/common';
import { GetLunchesService } from '../services/data/get-lunches.service';

@Component({
  selector: 'app-lunch',
  templateUrl: './lunch.component.html',
  styleUrls: ['./lunch.component.scss']
})
export class LunchComponent implements OnInit {

  lunchMenuResponse: any;
  lunchMenuLoaded: Promise<boolean>;
  lunchMenu: Array<LunchMeal> = [];
  dailyLunch: any;
  days: any[] = [[], [], [], [], []];

  constructor(private lunchGetter: GetLunchesService) { }

  ngOnInit() {
    this.getLunchMenu();

  }

  getDailyLunch() {
    const date: number = (new Date().getDay());
    this.dailyLunch = this.lunchMenuResponse.filter(meal => meal.days == date)
    //console.log(this.dailyLunch);
  }

  async getLunchMenu() {

    const lunchMenuResponse = await this.lunchGetter.getLunches().toPromise();
    this.lunchMenuResponse = lunchMenuResponse;
    this.lunchMenuLoaded = Promise.resolve(true);
    // 0 is sunday, 1 is monday, 2 is tuesday, 3 is wednesday, 4 is thursday, 5 is friday, 6 is saturday

    /**Sorts every individual day so that they're all ordered after type alphabetically*/
    for(var i = 0; i < this.days.length; i++) {
      this.days[i] = this.lunchMenuResponse.filter(meal => meal.days == i + 1);
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
    this.getDailyLunch();
  }

}

class LunchMeal {
  mealName: string;
  day: number;
  mealType: string;


  constructor(mealName: string, day: number, mealType: string) {
    this.mealName = mealName;
    this.day = day;
    this.mealType = mealType;
  }
}
