import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})

export class EventsComponent implements OnInit {

  events: Array<Event> = [];
  newestEvents: Event[];
  imagePath: string = "../assets/images/lax5.jpg";

  constructor() { }

  ngOnInit() {
    this.getEvents();
  }

  getEvents() {
    const jsonString = '[ {"title": "Carola", "date": "11/12-19"}, {"title": "Lasses orkester", "date": "12/12-19"}, ' +
      '{"title": "Tummels trumma", "date": "15/12-19"}, ' +
      '{"title": "Antons gitar trio", "date": "19/12-19"}, ' +
      '{"title": "Gurras ståbasstämma", "date": "24/12-19"}]';
    const jsonObj = JSON.parse(jsonString);

    jsonObj.forEach(val => {
      const temp: Event = new Event(val.title, val.date);
      this.events.push(temp);
    });
    
    // this.events = JSON.parse(jsonString) ;

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

  }

  getEventPictures(date: string) {
    const event: Event = this.events.find(x => x.date === date);
    event.pictures = Array<string>();
    if(event) {
      for (let i = 0; i<5; i++) {
        event.pictures.push(this.imagePath);
      }
    }
  }
  

}



class Event {
  title: string;
  date: string;
  pictures: Array<string> = [];
  constructor(title: string, date: string){
    this.title = title;
    this.date = date;
  }

}
