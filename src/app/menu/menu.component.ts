import {Component, OnInit} from "@angular/core";
import {MenuService} from "./menu.service";

@Component({
  selector: 'med-menu',
  templateUrl: "menu.component.html",
  providers: [MenuService]
})
export class MenuComponent implements OnInit {


  constructor(private menuService: MenuService) {
  }

  menuOptions: string[];

  ngOnInit(): void {
    this.menuService.getMenuOption().subscribe(data => this.menuOptions = data);
  }


  onClick(event): void {

    let menu = document.getElementById('menu').children;
    for (let entry in menu) {
      console.log(entry);
    }

    console.log(event);
    event.target.classList.remove('active');
  }
}
