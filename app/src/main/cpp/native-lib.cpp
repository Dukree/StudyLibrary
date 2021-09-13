#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_max_studylibrary_MainActivity_getSerial(JNIEnv *env, jobject thiz) {
    //Находим класс
jclass cls = env->FindClass("com/max/studylibrary/SerialNumber");
    //Получаем метод
jmethodID methodId = env->GetMethodID(cls,"<init>", "()V");
    //Создаем новый объект
jobject classobj = env->NewObject(cls,methodId);
    //Получаем метод
jmethodID getMethod = env->GetMethodID(cls,"getSerial", "()Ljava/lang/String;");
    // Вызываем метод объекта
jstring callobj =(jstring) env->CallObjectMethod(classobj,getMethod);
    //Получаем указатель на массив символов String
const char *strReturn = env ->GetStringUTFChars(callobj,0);
    //Освобождаем выделенную под строку область памяти
    env->ReleaseStringUTFChars(callobj,strReturn);
    //
    return (jstring) strReturn;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_max_studylibrary_MainActivity_getPackages(JNIEnv *env, jobject thiz) {
    //
    jclass cls = env ->FindClass("com/max/studylibrary/Package");
    //
    jmethodID methodId = env ->GetMethodID(cls,"<init>", "()V");
    //
    jobject clsobj = env->NewObject(cls,methodId);
    //
    jmethodID getMethod = env->GetMethodID(cls,"getPackages", "()Ljava/util/List;");
    //
    jstring callobject =(jstring) env ->CallObjectMethod(clsobj,getMethod);
    //
    const char *strReturning = env ->GetStringUTFChars(callobject,0);
    //
    env->ReleaseStringUTFChars(callobject,strReturning);
    //
    return (jstring) strReturning;
}