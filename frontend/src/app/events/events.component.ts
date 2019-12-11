import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})

export class EventsComponent implements OnInit {

  events: Array<Event> = [];
  newestEvents: Event[];
  currentIndex: number;
  imagePath: string = "../assets/images/lax5.jpg";

  constructor() { }

  ngOnInit() {
    this.getEvents();
  }

  getEvents() {
    const jsonString = '[ {"title": "Carola", "date": "7-12-2019"}, {"title": "Lasses orkester", "date": "12-12-2019"}, ' +
      '{"title": "Tummels trumma", "date": "15-12-2019"}, ' +
      '{"title": "Antons gitar trio", "date": "19-12-2019"}, ' +
      '{"title": "Gurras ståbasstämma", "date": "24-12-2019"}]';
    const jsonObj = JSON.parse(jsonString);

    jsonObj.forEach(val => {
      const temp: Event = new Event(val.title, val.date);
      this.events.push(temp);
    });

    const today = new Date();

    const nextEvent: number = this.events.findIndex(x => {
      const split = x.date.split("-");
      const tempDate: Date = new Date(+split[2] + '-' + split[1] + '-' + split[0]);
      return tempDate >= today;
    })

    this.currentIndex = nextEvent;

    console.log(nextEvent);

    if ( this.events != null) {
    const eventLength: number = this.events.length;
    switch (eventLength) {
      case 0: this.newestEvents = null;
              break;
      case 1: this.newestEvents = [new Event(this.events[nextEvent].title, this.events[nextEvent].date)]
              break;
      default: this.newestEvents = [new Event(this.events[nextEvent].title, this.events[nextEvent].date),
        new Event(this.events[nextEvent + 1].title, this.events[nextEvent + 1].date)];
               break;
    }
    }

    console.log(this.newestEvents);
    console.log(this.events);

  }

  getEventPictures(date: string) {
    const event: Event = this.events.find(x => x.date === date);
    event.pictures = Array<string>();
    if(event) {
      for (let i = 0; i < 5; i++) {
        event.pictures.push(this.imagePath);
      }
    }
  }


}



class Event {
  title: string;
  date: string;
  img: any;
  pictures: Array<string> = [];
  constructor(title: string, date: string){
    this.title = title;
    this.date = date;
  }

}
