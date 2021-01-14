package com.leysoft.syntax

import com.leysoft.algebra.Applicative

private[syntax] trait ApplicativeSyntax:
  extension [F[_], A](a: A)
    def pure(using F: Applicative[F]): F[A] = F.pure(a)
