#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_max_studylibrary_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


extern "C"
JNIEXPORT jstring JNICALL
Java_com_max_studylibrary_MainActivity_getSerial(JNIEnv *env, jobject thiz) {
jclass cls = env->FindClass("com/max/studylibrary/SerialNumber");
jmethodID methodId = env->GetMethodID(cls,"<init>", "()V");
jobject classobj = env->NewObject(cls,methodId);
jmethodID getMethod = env->GetMethodID(cls,"getSerial", "()Ljava/lang/String;");
jstring callobj =(jstring) env->CallObjectMethod(classobj,getMethod);
const char *strReturn = env ->GetStringUTFChars(callobj,0);
}