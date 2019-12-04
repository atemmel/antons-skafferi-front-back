import { Component, OnInit } from '@angular/core';
import {GetCategoriesService} from '../services/data/get-categories.service';
import {GetItemsService} from '../services/data/get-items.service';

@Component({
  selector: 'app-dinner',
  templateUrl: './dinner.component.html',
  styleUrls: ['./dinner.component.scss']
})
export class DinnerComponent implements OnInit {
  menu: Record<number, Category> = {};
  chefsChoice: Category;
  menuForHTML: Array<Category> = [];

  categoryResponse: any;
  itemResponse: any;
  categoryArray: Array<Category> = [];
  itemArray: Array<Item> = [];
  dataLoaded: Promise<boolean>;

  constructor(private categoryGetter: GetCategoriesService, private itemGetter: GetItemsService) {}

  ngOnInit() {
    this.getMenu();
  }

  async getMenu() {
    const categoryResponse = await this.categoryGetter.getCategories().toPromise();
    this.categoryResponse = categoryResponse;
    const itemResponse = await this.itemGetter.getItems().toPromise();
    this.itemResponse = itemResponse;
    this.dataLoaded = Promise.resolve(true);

    this.categoryResponse.forEach(val => {
      const temp: Category = val;
      this.categoryArray.push(val);
    });

    this.itemResponse.forEach(item => {
      const temp: Item = item;
      this.itemArray.push(item);
    })

    this.categoryArray.forEach(item => {
      this.menu[item.itemcategoryid] = new Category(item.itemcategoryid, item.name, item.url);
    });

    this.itemArray.forEach(item => {
      this.menu[item.itemcategory].items.push(item);
    });

    Object.keys(this.menu).forEach(key => {
      if (this.menu[key].name === "Kockens val") {
        this.chefsChoice = this.menu[key];
        this.menu[key] = null;
      } else {
        this.menuForHTML.push(this.menu[key]);
      }
    });
  }
}

class Item {
  itemid: number;
  title: string;
  price: number;
  description: string;
  type: string;
  itemcategory: number;
}

class Category {
  itemcategoryid: number;
  name: string;
  url: string;
  items: Array<Item> = [];

  constructor(id: number, name: string, url: string) {
    this.itemcategoryid = id;
    this.name = name;
    this.url = url;
  }
}
