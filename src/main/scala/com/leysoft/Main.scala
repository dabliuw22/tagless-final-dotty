package com.leysoft

import com.leysoft.algebra.Functor
import interpreter.option.{given _}
import interpreter.future.{given _}
import syntax.applicative._
import syntax.apply._
import syntax.functor._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Success

object Main {

  def main(args: Array[String]): Unit = {
    val program: Program[Option] = new Program[Option]
    val option = program
      .pure(1)
      .fmap(_ + 2)
      .ap(((x: Int) => x * 2).pure) <*> ((x: Int) => x.toString).pure
    println(option)
    val future: Future[Int] = Future.successful(1) <> (_ + 2)
    future.onComplete {
      case Success(value) => println(value)
      case _              => println("Error...")
    }
  }
}

