# SwensonHe-Challenge

## I. Add arithmetic operators
- First solution: ( 3 + 1 ) / 3 * 9 = 12 
- Second solution: ( 3 + 1 ) / ( 3 / 9 ) = 12

-------------------

## II.  Anagram Strings

 - First solution (Sorting strings):
```kotlin 
      private fun isAnagram_firstSolution(firstString: String, secondString: String): Boolean {
        val s1 = firstString.lowercase(Locale.getDefault()).replace("\\s".toRegex(), "")
        val s2 = secondString.lowercase(Locale.getDefault()).replace("\\s".toRegex(), "")
        val firstArray = s1.toCharArray()
        val secondArray = s2.toCharArray()
        firstArray.sort()
        secondArray.sort()
        if (firstArray.size != secondArray.size) return false
        for (i in firstArray.indices) {
            if (firstArray[i] != secondArray[i])
                return false
        }
        return true
    }

```

- Second solution (Hash Maps):
```kotlin 
    private fun isAnagram_secondSolution(firstString: String, secondString: String): Boolean {
        val firstMap = HashMap<Char, Int>()
        val secondMap = HashMap<Char, Int>()
        val s1 = firstString.lowercase(Locale.getDefault()).replace("\\s".toRegex(), "")
        val s2 = secondString.lowercase(Locale.getDefault()).replace("\\s".toRegex(), "")
        s1.forEach {
            if (!firstMap.containsKey(it))
                firstMap[it] = 1
            else firstMap[it] = firstMap[it]!! + 1
        }
        s2.forEach {
            if (!secondMap.containsKey(it))
                secondMap[it] = 1
            else secondMap[it] = secondMap[it]!! + 1
        }

        return (firstMap == secondMap)
    }

```
-------------------

## III. Generate the nth Fibonacci number
A. recursive approach
```kotlin 
    private fun fibonacciRecursive(n: Int): Int {
        if (n <= 1) return 1
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
    }

```
B. iterative approach
```kotlin 
    private fun fibonacciIterative(n: Int): Int {
        val intArray = IntArray(n + 2)
        intArray[0] = 1
        intArray[1] = 1
        for (i in 2 until n + 1) {
            intArray[i] = intArray[i - 1] + intArray[i - 2]
        }
        return intArray[n]
    }
```

-----------------

## IV. Currency converter: find the source code above.
