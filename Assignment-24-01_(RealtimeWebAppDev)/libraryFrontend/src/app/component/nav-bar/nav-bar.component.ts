import { Component, OnInit } from "@angular/core";
import { CartCountService } from "src/app/provider/cart-count.service";

@Component({
  selector: "app-nav-bar",
  templateUrl: "./nav-bar.component.html",
  styleUrls: ["./nav-bar.component.scss"]
})
export class NavBarComponent implements OnInit {
  cartCount: number;
  constructor(private cartCountService: CartCountService) {}

  ngOnInit() {
    this.cartCountService.currentCount.subscribe(
      count => (this.cartCount = count)
    );
  }
}
