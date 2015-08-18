package stagedparsec

import scala.virtualization.lms.common._
import scala.language.implicitConversions

/**
 * an implementation of `Reader` as staged struct
 * based on a previous implementation in
 * https://github.com/manojo/experiments/
 */


trait ReaderOps extends Base {

  /**
   * An abstract type corresponding
   * to the actual representation of a Reader
   * This is done so that we can either use
   * structs, or other (ex. CPS) representations
   * of a Reader in subtraits
   */
  type Reader[+T]

  type Elem
  type Input <: Reader[Elem]

  //need manifests for later
  implicit val mInput: Manifest[Input]

  /**
   * It would be ideal to give a specification of the operations
   * that a Reader can perform here. But it's actually not that
   * easy, because in the CPS-encoded case we seek to avoid the notion
   * of a Rep[Reader] while in the struct case we have them. Hence the spec
   * given in the form of comments:
   *
   * A Reader implementation should confer the following operations on a
   * Reader/Rep[Reader]:
   *    * def first: Rep[Elem]
   *    * def rest: Rep[Input]
   *    * def atEnd: Rep[Boolean]
   *    * def offset: Rep[Int]
   */

}
