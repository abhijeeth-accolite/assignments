import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";
import { Book } from "src/app/model/book";
import { CartItem } from "../model/cart-item";

@Injectable({
  providedIn: "root"
})
export class BookService {
  constructor(private http: HttpClient) {}

  getBooks(): Observable<any> {
    return this.http.get("/libraryBackend/books");
  }

  getBook(): Observable<any> {
    return this.http.get("/libraryBackend/books/1");
  }

  addBook(book: Book): Observable<any> {
    return this.http.post("/libraryBackend/books", book);
  }

  addToCart(cartItem: CartItem): Observable<any> {
    return this.http.post("/libraryBackend/cart", cartItem);
  }
}
