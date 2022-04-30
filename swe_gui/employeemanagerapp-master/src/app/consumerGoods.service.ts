import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Consumergoods } from './consumergoods';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class ConsumerGoodsService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getConsumerGoods(): Observable<Consumergoods[]> {
    return this.http.get<Consumergoods[]>(`${this.apiServerUrl}/api/consumergoods/getAll`);
  }

  public addConsumerGoods(consumerGoods: Consumergoods): Observable<Consumergoods> {
    console.log(consumerGoods["description"])
    console.log(`?description=${consumerGoods["description"]}&bestbeforedateday=${consumerGoods["day"]}&bestbeforedatemonth=${consumerGoods["month"]}&bestbeforedateyear=${consumerGoods["year"]}&quantityvalue=${consumerGoods["value"]}&quantity=${consumerGoods["shortcut"]}&storage=${consumerGoods["storage"]}&storagetype=${consumerGoods["storageType"]}`)

    return this.http.post<Consumergoods>(`${this.apiServerUrl}/api/consumergoods/add?eancode=${consumerGoods["eancode"]}&description=${consumerGoods["description"]}&bestbeforedateday=${consumerGoods["day"]}&bestbeforedatemonth=${consumerGoods["month"]}&bestbeforedateyear=${consumerGoods["year"]}&quantityvalue=${consumerGoods["value"]}&quantity=${consumerGoods["shortcut"]}&storage=${consumerGoods["storage"]}&storagetype=${consumerGoods["storageType"]}`, consumerGoods);
  }

  public updateConsumerGoods(consumerGoods: Consumergoods): Observable<Consumergoods> {
    console.log(consumerGoods)
    return this.http.put<Consumergoods>(`${this.apiServerUrl}/api/consumergoods/update?eancode=${consumerGoods["eancode"]}&description=${consumerGoods["description"]}&bestbeforedateday=${consumerGoods["day"]}&bestbeforedatemonth=${consumerGoods["month"]}&bestbeforedateyear=${consumerGoods["year"]}&quantityvalue=${consumerGoods["value"]}&quantity=${consumerGoods["shortcut"]}&storage=${consumerGoods["storage"]}&storagetype=${consumerGoods["storageType"]}`, consumerGoods);
  }

  public deleteConsumerGoods(consumerGoodsEANCode: number): Observable<void> {
    console.log(`?id=${consumerGoodsEANCode}`)
    return this.http.delete<void>(`${this.apiServerUrl}/api/consumergoods/delete?eancode=${consumerGoodsEANCode}`);
  }
}
