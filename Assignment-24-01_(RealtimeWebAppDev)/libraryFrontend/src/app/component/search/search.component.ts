import { Component, OnInit } from "@angular/core";
import { BookService } from "src/app/provider/book.service";

@Component({
  selector: "app-search",
  templateUrl: "./search.component.html",
  styleUrls: ["./search.component.scss"]
})
export class SearchComponent implements OnInit {
  book: any;
  constructor(private bookService: BookService) {}

  ngOnInit() {
    this.bookService.getBook().subscribe(response => {
      if (response) {
        this.book = response;
      }
    });
  }
}
