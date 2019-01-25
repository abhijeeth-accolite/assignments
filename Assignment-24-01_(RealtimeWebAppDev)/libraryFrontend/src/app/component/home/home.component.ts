import { Component, OnInit } from "@angular/core";
import { BookService } from "src/app/provider/book.service";
import { Book } from "src/app/model/book";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.scss"]
})
export class HomeComponent implements OnInit {
  book: Book;
  constructor(private bookService: BookService) {}

  ngOnInit() {
    this.book = new Book();
  }

  postData() {
    this.bookService.addBook(this.book).subscribe(response => {
      console.log(response);
    });
  }
}
