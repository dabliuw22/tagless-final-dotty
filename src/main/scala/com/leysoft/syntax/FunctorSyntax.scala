package com.leysoft.syntax

import com.leysoft.algebra.Functor

private[syntax] trait FunctorSyntax:
  extension [F[_], A, B](fa: F[A])(using F: Functor[F])
    def fmap(f: A => B): F[B] = F.fmap(fa)(f)
    def <>(f: A => B): F[B] = fa.fmap(f)
