#include "com_panayotis_jerminal_TermWindows.h"
#include <windows.h>

JNIEXPORT jint JNICALL Java_com_panayotis_jerminal_TermWindows_getWidth (JNIEnv * env, jclass class) {
    CONSOLE_SCREEN_BUFFER_INFO csbi;
    int columns, rows;
    GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &csbi);
    columns = csbi.srWindow.Right - csbi.srWindow.Left + 1;
    rows = csbi.srWindow.Bottom - csbi.srWindow.Top + 1;
    return columns;
}
