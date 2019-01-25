import { Component, OnInit, OnChanges } from "@angular/core";
import { BookService } from "src/app/provider/book.service";
import { CartItem } from "src/app/model/cart-item";

@Component({
  selector: "app-search",
  templateUrl: "./search.component.html",
  styleUrls: ["./search.component.scss"]
})
export class SearchComponent implements OnInit {
  books: any = [];
  filteredBooks: any = [];
  searchString: string;
  constructor(private bookService: BookService) {}

  ngOnInit() {
    this.bookService.getBooks().subscribe(response => {
      if (response && response.length > 0) {
        this.books = response;
        this.filteredBooks = this.books;
      }
    });
  }

  filterBooks() {
    this.filteredBooks = this.books.filter(function(book) {
      return book.name.includes(this.searchString);
    });
  }

  addToCart(bookId) {
    let cartItem = new CartItem();
    cartItem.bookId = bookId;
    cartItem.userId = 1;
    this.bookService.addToCart(cartItem).subscribe(response => {
      console.log(response);
    });
  }
}
