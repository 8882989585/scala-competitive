package leetcode


/**
 * https://leetcode.com/problems/group-anagrams/
 */
object Question49 extends App {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    import scala.collection.mutable
    import scala.collection.mutable.ListBuffer
    val mapper = new mutable.HashMap[String, mutable.ListBuffer[String]]()
    val result = new ListBuffer[List[String]]()
    for (str <- strs) {
      if (mapper.contains(str.toCharArray.sorted.mkString)) {
        mapper(str.toCharArray.sorted.mkString).addOne(str)
      } else {
        val temp = new ListBuffer[String]()
        temp.addOne(str)
        mapper(str.toCharArray.sorted.mkString) = temp
      }
    }
    mapper.values.map(m => m.toList).toList
  }

  println(groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat")))
}
