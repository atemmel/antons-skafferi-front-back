import { Component, OnInit } from '@angular/core';
import {GetEventsService} from '../services/data/get-events.service';
import {GetImageService} from '../services/data/get-image.service';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})

export class EventsComponent implements OnInit {

  events: Array<Event> = [];
  newestEvents: Array<Event> = [];
  currentIndex: number;
  imagePath: string = "../assets/images/lax5.jpg";
  eventsLoaded: Promise<boolean>;
  imagesLoaded: Promise<boolean>;
  newestEventsLoaded: Promise<boolean>;

  constructor(private eventGetter: GetEventsService, private imageGetter: GetImageService, private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.getEvents();
  }

  async getEvents() {
    const resp: any = await this.eventGetter.getEvents().toPromise();


    // const tempArr: Array<Event> = [];
    for (const x of resp) {
      const temp: Event = x;
      let tempProm: Promise<boolean>;
      const response = await this.imageGetter.getImage(temp.picture).toPromise();
      // console.log(response);
      temp.picture = this.sanitizer.bypassSecurityTrustResourceUrl('data:image/jpeg;base64,' + response);
      tempProm = Promise.resolve(true);
      this.events.push(new Event(temp.title, temp.eventdate, temp.picture));
    }
    this.imagesLoaded = Promise.resolve(true);
    this.eventsLoaded = Promise.resolve(true);


    let today = new Date();

    //today = new Date(today.getFullYear(), today.getMonth(), today.getDay());
    console.log(this.events);
    let nextEvent: number = this.events.findIndex(x => {
      const split = x.eventdate.split("-");
      const tempDate: Date = new Date(split[0] + '-' + split[1] + '-' + split[2]);
      tempDate.setHours(today.getHours());
      tempDate.setMinutes(today.getMinutes());
      tempDate.setSeconds(today.getSeconds() + 1);
      return tempDate >= today;
    });
    console.log(nextEvent);
    this.currentIndex = nextEvent;

    if (nextEvent < 0) {
      this.currentIndex = 0;
      return;
    }
    let eventLength: number = this.events.length;
    
    if (nextEvent === this.events.length -1) {
      eventLength = 1;
    }
    
    if ( this.events != null) {
    
    switch (eventLength) {
      case 0: this.newestEvents = null;
              break;
      case 1: this.newestEvents =
        [new Event(this.events[nextEvent].title, this.events[nextEvent].eventdate, this.events[nextEvent].picture)];
              break;
      default: this.newestEvents =
        [new Event(this.events[nextEvent].title, this.events[nextEvent].eventdate, this.events[nextEvent].picture),
        new Event(this.events[nextEvent + 1].title, this.events[nextEvent + 1].eventdate, this.events[nextEvent + 1].picture)];
               break;
    }
    }
    this.newestEventsLoaded = Promise.resolve(true);
    
  }

  getEventPictures(date: string) {
    const event: Event = this.events.find(x => x.eventdate === date);
    event.pictures = Array<string>();
    if (event) {
      for (let i = 0; i < 5; i++) {
        event.pictures.push(this.imagePath);
      }
    }
  }


}



class Event {
  title: string;
  eventdate: string;
  picture: any;
  pictures: Array<string> = [];
  constructor(title: string, date: string, picture: string){
    this.title = title;
    this.eventdate = date;
    this.picture = picture;

  }

}
