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
  newestEvents: Event[];
  currentIndex: number;
  imagePath: string = "../assets/images/lax5.jpg";
  eventsLoaded: Promise<boolean>;
  imagesLoaded: Promise<boolean>;

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
      console.log(temp.picture);
      tempProm = Promise.resolve(true);
      this.events.push(new Event(temp.title, temp.eventdate, temp.picture));
    }
    this.imagesLoaded = Promise.resolve(true);

    console.log(this.events);
    /*const jsonString = '[ {"title": "Carola", "date": "7-12-2019"}, {"title": "Lasses orkester", "date": "12-12-2019"}, ' +
      '{"title": "Tummels trumma", "date": "15-12-2019"}, ' +
      '{"title": "Antons gitar trio", "date": "19-12-2019"}, ' +
      '{"title": "Gurras ståbasstämma", "date": "24-12-2019"}]';
    const jsonObj = JSON.parse(jsonString);

    jsonObj.forEach(val => {
      const temp: Event = new Event(val.title, val.date, "");
      this.events.push(temp);
    });*/

    const today = new Date();

    let nextEvent: number = this.events.findIndex(x => {
      const split = x.eventdate.split("-");
      const tempDate: Date = new Date(+split[2] + '-' + split[1] + '-' + split[0]);
      return tempDate >= today;
    });

    this.currentIndex = nextEvent;
    if (nextEvent < 0) {
      nextEvent++;
    }

    if ( this.events != null) {
    const eventLength: number = this.events.length;
    switch (eventLength) {
      case 0: this.newestEvents = null;
              break;
      case 1: this.newestEvents =
        [new Event(this.events[nextEvent].title, this.events[nextEvent].eventdate, this.events[nextEvent].picture)];
              break;
      default: this.newestEvents =
        [new Event(this.events[nextEvent].title, this.events[nextEvent].eventdate, this.events[nextEvent].picture),
        new Event(this.events[nextEvent + 1].title, this.events[nextEvent + 1].eventdate, this.events[nextEvent].picture)];
               break;
    }
    }
    this.eventsLoaded = Promise.resolve(true);

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
