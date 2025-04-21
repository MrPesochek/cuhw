function processProducts(products) {
  const availableProducts = products.filter(p => p.inStock);
  const productNamesAndPrices = products.map(({ name, price }) => ({ name, price }));
  const firstBook = products.find(p => p.category === "Книги");
  const hasLaptop = products.some(p => p.name === "Ноутбук");
  const updatedProducts = [
    ...products,
    { id: 6, name: "Планшет", category: "Электроника", price: 499, inStock: true }
  ];
  return { availableProducts, productNamesAndPrices, firstBook, hasLaptop, updatedProducts };
}

const products = [
  { id: 1, name: "Телефон", category: "Электроника", price: 699, inStock: true },
  { id: 2, name: "Ноутбук", category: "Электроника", price: 1299, inStock: false },
  { id: 3, name: "Чашка", category: "Дом и кухня", price: 15, inStock: true },
  { id: 4, name: "Книга", category: "Книги", price: 25, inStock: true },
  { id: 5, name: "Наушники", category: "Электроника", price: 199, inStock: false }
];

console.log(processProducts(products));
