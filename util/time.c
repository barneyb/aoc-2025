#include <time.h>
#include <stdlib.h>

long long _j_micro_time(void) {
    struct timespec ts;
    int a = clock_gettime(CLOCK_PROCESS_CPUTIME_ID, &ts);
    if (a == 0) {
        int c = ts.tv_sec;
        int d = ts.tv_nsec;
        return c * 1000000 + d / 1000;
    }
    exit(17);
}
