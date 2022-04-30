export interface Consumergoods {
  eancode: number;
  food: {
    description: string;
    bbd: {
      day: string;
      month: string;
      year: string;
    }
  }
  quantity: {
    description: string;
    shortcut: string;
    value: {
    value: string;
    }
  }
  storage: string;
  storageType: string;
}
