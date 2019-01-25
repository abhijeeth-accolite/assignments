import { TestBed } from '@angular/core/testing';

import { CartCountService } from './cart-count.service';

describe('CartCountService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CartCountService = TestBed.get(CartCountService);
    expect(service).toBeTruthy();
  });
});
