/**
 * @param {string} s
 * @return {string}
 */
const longestPalindrome = function (s) {
    let left = 0;
    let right = 0;
    let strlen = s.length;
    let len = 1;
    let maxStart = 0;
    let maxLen = 0;

    for (let i = 0; i < strlen; i++) {
        left = i - 1;
        right = i + 1;
        while (left >= 0 && s.charAt(i) === s.charAt(left)) {
            left--;
            len++;
        }
        while (right < strlen && s.charAt(i) === s.charAt(right)) {
            right++;
            len--;
        }
        while (left >= 0 && right < strlen && s.charAt(left) === s.charAt(right)) {
            right++;
            left--;
            len += 2;
        }
        if (len > maxLen) {
            maxStart = left;
            maxLen = len
        }
        len = 1//下次重新从1开始
    }

    return s.substring(maxStart + 1, maxStart + maxLen + 1)

};