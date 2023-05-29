/**
 * @param {Function} fn
 */
// function memoize(fn) {
//     const mapRes = {};
//     return function (...args) {
//         if (mapRes.has(JSON.stringify(args))) {
//             return mapRes[JSON.stringify(args)]
//         } else {
//             mapRes[JSON.stringify(args)] = fn(args)
//             return mapRes[JSON.stringify(...args)]
//         }
//     }
// }


function memoize(fn) {
    const hasRes = new Map();
    return function (...args) {
        if (hasRes.has(JSON.stringify(args)) ) {
            return hasRes.get(JSON.stringify(args));
        }else{
            const res = fn(...args);
            hasRes.set(JSON.stringify(args), res);
            return res;
        }
    }
}

/**
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1
 */
