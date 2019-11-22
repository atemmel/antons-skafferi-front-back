import { Component, OnInit } from '@angular/core';
import {computeLineStartsMap} from '@angular/core/schematics/utils/line_mappings';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})

export class EventsComponent implements OnInit {

  events: Event[];
  newestEvents: Event[];

  constructor() { }

  ngOnInit() {
    this.getEvents();
  }

  getEvents() {
    const jsonString = '[ {"title": "Carola", "date": "11/12-19"}, {"title": "Lasses orkester", "date": "12/12-19"}, ' +
      '{"title": "Tummels trumma", "date": "15/12-19"}, ' +
      '{"title": "Antons gitar trio", "date": "19/12-19"}, ' +
      '{"title": "Gurras ståbasstämma", "date": "24/12-19"}]'
    this.events = JSON.parse(jsonString) ;

    if ( this.events != null) {
    const eventLength: number = this.events.length;
    switch (eventLength) {
      case 0: this.newestEvents = null;
              break;
      case 1: this.newestEvents = [new Event(this.events[0].title, this.events[0].date)]
              break;
      default: this.newestEvents = [new Event(this.events[0].title, this.events[0].date),
        new Event(this.events[1].title, this.events[1].date)];
               break;
    }
    }

    console.log(this.newestEvents);
    console.log(this.events);

    /*if (eventLenght < 2) {
      this.newestEvents = null;
    } else {
      this.newestEvents = {events: [ {title: this.events.events[0].title, date: this.events.events[0].date},
          {title: this.events.events[1].title, date: this.events.events[1].date}]};
    }
    console.log(this.events);
    console.log(this.newestEvents);*/
  }

}

class Event {
  title: string;
  date: string;
  constructor(title: string, date: string){
    this.title = title;
    this.date = date;
  }
}
