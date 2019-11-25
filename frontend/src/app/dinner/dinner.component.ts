import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dinner',
  templateUrl: './dinner.component.html',
  styleUrls: ['./dinner.component.scss']
})
export class DinnerComponent implements OnInit {

  menu: Array<MenuItem> = [];
  image: any;

  constructor() {
  }

  ngOnInit() {
    this.getMenu();
  }


  getMenu() {
    let jsonObject: JSON;
    const jsonString: any = {
      "Kockens Val": [{"title": "Vildssvin", "description": "Vildssvinskottlett med potatismos och lingonsylt"},
        {"title": "Vild lax", "description": "Lax fångad vilt med färskpotatis som tillbehör"},
        {"title": "Renskav", "description": "Renskav med potatismos"}],
      "Förrätter": [{"title": "Skagentoast", "description": "Toast med skagenröra och en citronskiva"},
        {"title": "Vitlöksbröd", "description": "Baguett med vitlökssmör"},
        {"title": "Mozarellasticks", "description": "Friterad mozarella"}],
      "Vilt": [{"title": "Renskav", "description": "Renskav med potatismos"},
        {"title": "Älgfilè", "description": "Älgfilè med potatisgrattäng"},
        {"title": "Bäverstek", "description": "Bäverstek med potatis"}],
      "À La Carte": [{"title": "Lax", "description": "Lax med potatismos"},
        {"title": "Oxfilè", "description": "Oxfilè med potatisgratäng"},
        {"title": "Kötbullar", "description": "Köttbullar med potatismos med lingonsylt"}],
      "Dryck": [{"title": "Cola", "description": "Burk(33cl)"},
        {"title": "ÖL", "description": "Stor ÖL"}]
    };
    jsonObject = jsonString as JSON;

    console.log(jsonObject);

    for (let key in jsonObject) {
      let temp: MenuItem = new MenuItem(key);
      const temparray: Dish[] = jsonObject[key];

      temp.replaceDishes(temparray);
      this.menu.push(temp);
      temp = null;
    }

    console.log(this.menu[0]);



  }
}

class Dish {
  title: string;
  description: string;

  constructor(title: string, description: string) {
    this.title = title;
    this.description = description;
  }
}

class MenuItem {
  title: string;
  public dishes: Array<Dish> = [];

  constructor(title: string) {
    this.title = title;
  }

  addDish(newDish: Dish) {
    this.dishes.push(newDish);
  }
  replaceDishes(newDishArray: Dish[]) {
    this.dishes = newDishArray;
  }


}
