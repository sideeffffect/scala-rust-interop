#include "com_github_sideeffffect_scalarustinterop_Adder.h"
#include <stdio.h>

/*
 * Class:      com_github_sideeffffect_scalarustinterop_Adder
 * Method:     plus
 * Signature:  (I)I
 */
JNIEXPORT jint JNICALL Java_com_github_sideeffffect_scalarustinterop_Adder_plus(
    JNIEnv *env, jobject object, jint term) {
  jobject clazz = (*env)->GetObjectClass(env, object);
  jfieldID baseField = (*env)->GetFieldID(env, clazz, "base", "I");
  int base = (*env)->GetIntField(env, object, baseField);
  fprintf(stdout, "Printing from native library. term: %d\n", term);
  fprintf(stdout, "Printing from native library. base: %d\n", base);
  fflush(stdout);
  return base + term;
}
