package com.leysoft.interpreter

import com.leysoft.algebra.{Applicative, Apply, Functor}

import scala.concurrent.{ExecutionContext, Future}

object future:
  given instance(using ctx: ExecutionContext): Functor[Future] with
    override def fmap[A, B](fa: Future[A])(f: A => B): Future[B] =
      fa.map(f)
