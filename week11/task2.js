function binsearch(array, target) {
  let left = 0;
  let right = array.length - 1;
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    const value = array[mid];
    if (value === target) return mid;
    if (value < target) left = mid + 1;
    else right = mid - 1;
  }
  return -1;
}

const arr = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19];
console.log(binsearch(arr, 13));
console.log(binsearch(arr, 12));
console.log(binsearch(arr, 11));
