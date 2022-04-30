import { Component, OnInit } from '@angular/core';
import { Consumergoods } from './consumergoods';
import { ConsumerGoodsService } from './consumerGoods.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public consumerGoods: Consumergoods[];
  public editConsumerGoods: Consumergoods;
  public deleteConsumerGoods: Consumergoods;

  constructor(private consumerGoodsService: ConsumerGoodsService){}

  ngOnInit() {
    this.getConsumerGoods();
  }

  public getConsumerGoods(): void {
    this.consumerGoodsService.getConsumerGoods().subscribe(
      (response: Consumergoods[]) => {
        this.consumerGoods = response;
        console.log(this.consumerGoods);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddConsumerGoods(addForm: NgForm): void {
    document.getElementById('add-consumerGoods-form').click();
    this.consumerGoodsService.addConsumerGoods(addForm.value).subscribe(
      (response: Consumergoods) => {
        console.log(response);
        this.getConsumerGoods();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        //addForm.reset();
      }
    );
  }

  public onUpdateConsumerGoods(consumerGoods: Consumergoods): void {
    this.consumerGoodsService.updateConsumerGoods(consumerGoods).subscribe(
      (response: Consumergoods) => {
        console.log(response);
        this.getConsumerGoods();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteConsumerGoods(employeeId: number): void {
    this.consumerGoodsService.deleteConsumerGoods(employeeId).subscribe(
      (response: void) => {
        console.log(response);
        this.getConsumerGoods();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchConsumerGoods(key: string): void {
    console.log(key);
    const results: Consumergoods[] = [];
    for (const consumerGood of this.consumerGoods) {
      if (consumerGood.food.description.toLowerCase().indexOf(key.toLowerCase()) !== -1
     // || employee.day.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || consumerGood.quantity.shortcut.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || consumerGood.storage.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(consumerGood);
      }
    }
    this.consumerGoods = results;
    if (!key) {
      this.getConsumerGoods();
    }
  }

  public onOpenModal(consumerGood: Consumergoods, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addConsumerGoodsModal');
    }
    if (mode === 'edit') {
      this.editConsumerGoods = consumerGood;
      button.setAttribute('data-target', '#updateConsumerGoodsModal');
    }
    if (mode === 'delete') {
      this.deleteConsumerGoods = consumerGood;
      button.setAttribute('data-target', '#deleteConsumerGoodsModal');
    }
    container.appendChild(button);
    button.click();
  }



}
