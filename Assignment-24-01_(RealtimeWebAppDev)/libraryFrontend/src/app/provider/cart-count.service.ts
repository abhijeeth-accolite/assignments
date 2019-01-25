import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class CartCountService {
  private countSource = new BehaviorSubject(0);
  currentCount = this.countSource.asObservable();

  constructor() {}

  changeCount(count: number) {
    this.countSource.next(count);
  }
}
