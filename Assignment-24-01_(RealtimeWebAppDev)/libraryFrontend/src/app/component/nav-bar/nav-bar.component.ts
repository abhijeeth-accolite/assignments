import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-nav-bar",
  templateUrl: "./nav-bar.component.html",
  styleUrls: ["./nav-bar.component.scss"]
})
export class NavBarComponent implements OnInit {
  cartItemCount: number;
  orderCount: number;
  constructor() {}

  ngOnInit() {
    // TODO - set this to number of items in cart
    this.cartItemCount = 5;
    this.orderCount = 7;
  }
}
