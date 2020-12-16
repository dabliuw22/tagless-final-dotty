package com.leysoft.interpreter

import com.leysoft.algebra.{Applicative, Apply, Functor}

import scala.concurrent.{ExecutionContext, Future}

object future {

  given (using ctx: ExecutionContext) as Applicative[Future]
      with Apply[Future]
      with Functor[Future]:
    override def pure[A](x: A): Future[A] = Future.successful(x)
    
    override def ap[A, B](ff: Future[A => B])(fa: Future[A]): Future[B] =
      ff.flatMap(f => fa.map(f))
    
    override def fmap[A, B](fa: Future[A])(f: A => B): Future[B] =
      fa.map(f)
}
