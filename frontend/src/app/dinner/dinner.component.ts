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
      "Kockens Val": { "array": [{"title": "Vildssvin", "description": "Vildssvinskottlett med potatismos och lingonsylt"},
        {"title": "Vild lax", "description": "Lax fångad vilt med färskpotatis som tillbehör"},
        {"title": "Renskav", "description": "Renskav med potatismos"}], "picture" : ""},
      "Förrätter": { "array": [{"title": "Skagentoast", "description": "Toast med skagenröra och en citronskiva"},
        {"title": "Vitlöksbröd", "description": "Baguett med vitlökssmör"},
        {"title": "Mozarellasticks", "description": "Friterad mozarella"}],
        "picture": "https://receptfavoriter.se/sites/default/files/vitloksbrod_65_980.jpg" },
      "Vilt": {"array": [{"title": "Renskav", "description": "Renskav med potatismos"},
        {"title": "Älgfilè", "description": "Älgfilè med potatisgrattäng"},
        {"title": "Bäverstek", "description": "Bäverstek med potatis"}],
        "picture": "https://images.ctfassets.net/wcifomac350q/74mxcPcxFKpghUOMKAGsyA/0b114891ec21bff5df58912bf7b018e5/img_viltbord_matbild.jpg?fm=webp&q=70" },
      "À La Carte": {"array": [{"title": "Lax", "description": "Lax med potatismos"},
        {"title": "Oxfilè", "description": "Oxfilè med potatisgratäng"},
        {"title": "Kötbullar", "description": "Köttbullar med potatismos med lingonsylt"}],
        "picture": "https://assets.icanet.se/q_auto,f_auto/imagevaultfiles/id_152536/cf_259/helstekt-oxfile-bg-1920x540.jpg?" },
      "Dryck": {"array": [{"title": "Cola", "description": "Burk(33cl)"},
        {"title": "ÖL", "description": "Stor ÖL"},
        {"title": "Vinflarra", "description": "Speedrun"}],
        "picture": "https://www.kingsizemag.se/wp-content/uploads/2019/05/beer-ls-580x345.jpg" }
    };
    jsonObject = jsonString as JSON;

    console.log(jsonObject);

    for (const key of Object.keys(jsonObject)) {
      let temp: MenuItem = new MenuItem(key);
      temp.pictureUrl = jsonObject[key].picture;
      const temparray: Dish[] = jsonObject[key].array;

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
  pictureUrl: string;
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
