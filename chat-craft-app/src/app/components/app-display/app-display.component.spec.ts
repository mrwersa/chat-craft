import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppDisplayComponent } from './app-display.component';

describe('AppDisplayComponent', () => {
  let component: AppDisplayComponent;
  let fixture: ComponentFixture<AppDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppDisplayComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
