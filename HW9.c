#include <jni.h>
#include "HW9.h"

JNIEXPORT float JNICALL Java_HW9_convertCtoF(JNIEnv *env, jobject obj, jint celsius)
{
  float fahrenheit = 0.0;
  fahrenheit = ((celsius * (9.0/5.0)) + 32.0);
  return fahrenheit;
}

JNIEXPORT int JNICALL Java_HW9_roundUp(JNIEnv *env, jobject obj, jint inputValue)
{
  int setNumber;
  int tempNumber = inputValue;

  if (tempNumber % 5 == 0)
  {
    setNumber = tempNumber;
  } else {
    setNumber = tempNumber + (5 - (tempNumber % 5));
  }
  return setNumber;
}
