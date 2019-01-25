import { Component, OnInit } from "@angular/core";
import { BookService } from "src/app/provider/book.service";
import { CartCountService } from "src/app/provider/cart-count.service";

@Component({
  selector: "app-cart",
  templateUrl: "./cart.component.html",
  styleUrls: ["./cart.component.scss"]
})
export class CartComponent implements OnInit {
  books: any = [];
  constructor(
    private bookService: BookService,
    private cartCountService: CartCountService
  ) {}

  ngOnInit() {
    this.bookService.getBooksFromCart().subscribe(response => {
      if (response && response.length > 0) {
        this.books = response;
        console.log(response);
        this.cartCountService.changeCount(this.books.length);
      }
    });
  }
}
