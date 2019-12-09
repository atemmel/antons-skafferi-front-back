import { BrowserModule } from '@angular/platform-browser';
import {enableProdMode, NgModule} from '@angular/core';

import { AngularDateTimePickerModule } from 'angular2-datetimepicker';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LunchComponent } from './lunch/lunch.component';
import { DinnerComponent } from './dinner/dinner.component';
import { EventsComponent } from './events/events.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BookingComponent } from './booking/booking.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatDatepickerModule,
  MatNativeDateModule,
  MatFormFieldModule,
  MatInputModule,
  MatSelectModule,
  MatDividerModule, DateAdapter
} from '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    LunchComponent,
    DinnerComponent,
    EventsComponent,
    FooterComponent,
    NavbarComponent,
    BookingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    AngularDateTimePickerModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatDividerModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(private dateAdapter: DateAdapter<Date>) {
    this.dateAdapter.setLocale('sv-SE');
    this.dateAdapter.getFirstDayOfWeek = () => 1;
  }
}
