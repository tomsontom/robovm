set(MACOSX_VERSION_MIN 10.6)
set(IPHONEOS_VERSION_MIN 5.0)

cmake_minimum_required(VERSION 2.8.8)
project(build)
include(CheckCCompilerFlag)
include(ExternalProject)

enable_testing()

if(NOT CMAKE_BUILD_TYPE)
  set(CMAKE_BUILD_TYPE "debug")
endif()

if(NOT ARCH)
  message(FATAL_ERROR "ARCH not set")
endif()
if(NOT ARCH MATCHES "^(x86|armv6|armv7|thumbv6|thumbv7)$")
  message(FATAL_ERROR "Unsupported ARCH: ${ARCH}")
endif()
if(NOT OS)
  message(FATAL_ERROR "OS not set")
endif()
if(NOT OS MATCHES "^(linux|macosx|ios)$")
  message(FATAL_ERROR "Unsupported OS: ${OS}")
endif()

if(OS STREQUAL "linux")
  set(LINUX YES)
  set(OS_FAMILY linux)
elseif(OS STREQUAL "macosx")
  set(MACOSX YES)
  set(DARWIN YES)
  set(OS_FAMILY darwin)
elseif(OS STREQUAL "ios")
  set(IOS YES)
  set(DARWIN YES)
  set(OS_FAMILY darwin)
endif()

if (ARCH STREQUAL "x86")
  set(X86 YES)
elseif (ARCH STREQUAL "armv6")
  set(ARM YES)
  set(ARMV6 YES)
elseif (ARCH STREQUAL "armv7")
  set(ARM YES)
  set(ARMV7 YES)
elseif (ARCH STREQUAL "thumbv6")
  set(ARM YES)
  set(THUMB YES)
  set(THUMBV6 YES)
elseif (ARCH STREQUAL "thumbv7")
  set(ARM YES)
  set(THUMB YES)
  set(THUMBV7 YES)
endif()

if(DARWIN)
  set(CARCH ${ARCH})
  if (ARCH STREQUAL "x86")
    set(CARCH i386)
  elseif (ARCH STREQUAL "thumbv6")
    set(CARCH armv6)
  elseif (ARCH STREQUAL "thumbv7")
    set(CARCH armv7)
  endif()
endif()

if(DARWIN)
  if(NOT SYSROOT)
    exec_program(xcode-select ARGS --print-path OUTPUT_VARIABLE XCODE_PATH)
    if(MACOSX)
      set(SYSROOT "${XCODE_PATH}/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.9.sdk")
      if(NOT IS_DIRECTORY ${SYSROOT})
        set(SYSROOT "${XCODE_PATH}/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.8.sdk")
      endif()
      if(NOT IS_DIRECTORY ${SYSROOT})
        message(FATAL_ERROR "No supported MacOSX SDK found")
      endif()
    elseif(IOS)
      if(ARCH STREQUAL "x86")
        set(SYSROOT "${XCODE_PATH}/Platforms/iPhoneSimulator.platform/Developer/SDKs/iPhoneSimulator7.1.sdk")
        if(NOT IS_DIRECTORY ${SYSROOT})
          message(FATAL_ERROR "No supported iPhoneSimulator SDK found")
        endif()
      else()
        set(SYSROOT "${XCODE_PATH}/Platforms/iPhoneOS.platform/Developer/SDKs/iPhoneOS7.1.sdk")
        if(NOT IS_DIRECTORY ${SYSROOT})
          message(FATAL_ERROR "No supported iPhoneOS SDK found")
        endif()
      endif()
    endif()
  endif()
endif()

# Set up global C and C++ compiler flags
set(C_FLAGS "${C_FLAGS} -std=gnu99")
set(CXX_FLAGS "${CXX_FLAGS} -std=gnu++11")
set(C_CXX_FLAGS "${C_CXX_FLAGS} -Wall -fvisibility=hidden -fdata-sections -ffunction-sections")
if(CARCH)
  set(C_CXX_FLAGS "${C_CXX_FLAGS} -arch ${CARCH}")
else()
  set(C_CXX_FLAGS "${C_CXX_FLAGS} -m32")
endif()
if (ARCH STREQUAL "thumbv6" OR ARCH STREQUAL "thumbv7")
  set(C_CXX_FLAGS "${C_CXX_FLAGS} -mthumb")
endif()
if(SYSROOT)
  set(C_CXX_FLAGS "${C_CXX_FLAGS} -isysroot ${SYSROOT}")
  set(CMAKE_OSX_SYSROOT "${SYSROOT}")
endif()
if(MACOSX)
  set(C_CXX_FLAGS "${C_CXX_FLAGS} -mmacosx-version-min=${MACOSX_VERSION_MIN}")
elseif(IOS)
  set(C_CXX_FLAGS "${C_CXX_FLAGS} -miphoneos-version-min=${IPHONEOS_VERSION_MIN}")
endif()

# Linker flags
if(CARCH)
  set(LD_FLAGS "${LD_FLAGS} -arch ${CARCH}")
else()
  set(LD_FLAGS "${LD_FLAGS} -m32")
endif()
if(SYSROOT)
  set(LD_FLAGS "${LD_FLAGS} -isysroot ${SYSROOT}")
endif()
if(MACOSX)
  set(LD_FLAGS "${LD_FLAGS} -mmacosx-version-min=${MACOSX_VERSION_MIN}")
endif()
if(IOS)
  set(LD_FLAGS "${LD_FLAGS} -miphoneos-version-min=${IPHONEOS_VERSION_MIN}")
endif()

set(CMAKE_C_FLAGS_RELEASE "-Os -DNDEBUG")
set(CMAKE_CXX_FLAGS_RELEASE "-Os -DNDEBUG")

set(CMAKE_C_FLAGS_DEBUG "${CMAKE_C_FLAGS_DEBUG} ${C_CXX_FLAGS} ${C_FLAGS}")
set(CMAKE_CXX_FLAGS_DEBUG "${CMAKE_CXX_FLAGS_DEBUG} ${C_CXX_FLAGS} ${CXX_FLAGS}")
set(CMAKE_C_FLAGS_RELEASE "${CMAKE_C_FLAGS_RELEASE} ${C_CXX_FLAGS} ${C_FLAGS}")
set(CMAKE_CXX_FLAGS_RELEASE "${CMAKE_CXX_FLAGS_RELEASE} ${C_CXX_FLAGS} ${CXX_FLAGS}")
set(CMAKE_EXE_LINKER_FLAGS "${CMAKE_EXE_LINKER_FLAGS} ${LD_FLAGS}")
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} ${LD_FLAGS}")
set(CMAKE_MODULE_LINKER_FLAGS "${CMAKE_MODULE_LINKER_FLAGS} ${LD_FLAGS}")

# Assembler flags
if(CARCH)
  set(ASM_FLAGS "${ASM_FLAGS} -c -arch ${CARCH}")
else()
  set(ASM_FLAGS "${ASM_FLAGS} -c -m32")
endif()
if (CMAKE_BUILD_TYPE STREQUAL "debug")
  set(ASM_FLAGS "${ASM_FLAGS} -g")
endif()
set(CMAKE_ASM_COMPILE_OBJECT "${CMAKE_C_COMPILER} ${ASM_FLAGS} -o <OBJECT> <SOURCE>")
enable_language(ASM)

if(LINUX)
  add_definitions(-DLINUX)
elseif(DARWIN)
  if(MACOSX)
    add_definitions(-DMACOSX)
  else()
    add_definitions(-DIOS)
  endif()
  add_definitions(-DDARWIN)
endif()

if (ARCH STREQUAL "x86")
  add_definitions(-DRVM_X86)
elseif (ARCH STREQUAL "armv6")
  add_definitions(-DRVM_ARMV6)
elseif (ARCH STREQUAL "armv7")
  add_definitions(-DRVM_ARMV7)
elseif (ARCH STREQUAL "thumbv6")
  add_definitions(-DRVM_THUMBV6)
elseif (ARCH STREQUAL "thumbv7")
  add_definitions(-DRVM_THUMBV7)
endif()

set(LIB_SUFFIX ".a")
if (CMAKE_BUILD_TYPE STREQUAL "debug")
  set(LIB_SUFFIX "-dbg.a")
endif()

set(INSTALL_DIR ${CMAKE_SOURCE_DIR}/target/binaries/${OS}/${ARCH})

message(STATUS "ARCH: ${ARCH}")
message(STATUS "OS: ${OS}")
message(STATUS "SYSROOT: ${SYSROOT}")
message(STATUS "CMAKE_BUILD_TYPE: ${CMAKE_BUILD_TYPE}")
message(STATUS "CMAKE_C_COMPILER: ${CMAKE_C_COMPILER}")
message(STATUS "CMAKE_CXX_COMPILER: ${CMAKE_CXX_COMPILER}")
message(STATUS "CMAKE_C_FLAGS: ${CMAKE_C_FLAGS}")
message(STATUS "CMAKE_CXX_FLAGS: ${CMAKE_CXX_FLAGS}")
message(STATUS "CMAKE_C_FLAGS_DEBUG: ${CMAKE_C_FLAGS_DEBUG}")
message(STATUS "CMAKE_CXX_FLAGS_DEBUG: ${CMAKE_CXX_FLAGS_DEBUG}")
message(STATUS "CMAKE_C_FLAGS_RELEASE: ${CMAKE_C_FLAGS_RELEASE}")
message(STATUS "CMAKE_CXX_FLAGS_RELEASE: ${CMAKE_CXX_FLAGS_RELEASE}")
message(STATUS "CMAKE_EXE_LINKER_FLAGS: ${CMAKE_EXE_LINKER_FLAGS}")
message(STATUS "CMAKE_SHARED_LINKER_FLAGS: ${CMAKE_SHARED_LINKER_FLAGS}")
message(STATUS "CMAKE_MODULE_LINKER_FLAGS: ${CMAKE_MODULE_LINKER_FLAGS}")

# Ugly hardcoding. This is the offset in bytes of the gcDescriptor member in the Class struct from core/include/robovm/types.h
# Should be the value of sizeof(void*)*3 for the target platform.
set(EXTGC_MARK_DESCR_OFFSET 12)

set(EXT_C_FLAGS "${C_CXX_FLAGS}")
set(EXT_LD_FLAGS "${CMAKE_EXE_LINKER_FLAGS}")
set(EXTGC_C_FLAGS "${EXT_C_FLAGS} -DGC_DISABLE_INCREMENTAL -DGC_FORCE_UNMAP_ON_GCOLLECT -DMARK_DESCR_OFFSET=${EXTGC_MARK_DESCR_OFFSET}")
set(EXTGC_LD_FLAGS "${EXT_LD_FLAGS}")
if(DARWIN)
  set(EXTGC_C_FLAGS "${EXTGC_C_FLAGS} -DNO_DYLD_BIND_FULLY_IMAGE")
endif()
set(EXTGC_PARAMS  "--enable-shared=no --enable-munmap=1")
if (CMAKE_BUILD_TYPE STREQUAL "debug")
  set(EXTGC_C_FLAGS "${EXTGC_C_FLAGS} -g")
  set(EXTGC_PARAMS "${EXTGC_PARAMS} --enable-gc-debug=yes")
endif()
if (IOS)
  if (ARCH MATCHES ".*(thumb|arm).*")
    set(EXT_HOST --host=arm-apple-darwin7)
  endif()
endif()
ExternalProject_Add(libatomic_ops 
  GIT_REPOSITORY git://github.com/ivmai/libatomic_ops.git
  GIT_TAG f5f47f7b9c70df2e0d371dd2f303a0dec1a37223
  UPDATE_COMMAND ""
  CONFIGURE_COMMAND "" 
  BUILD_COMMAND ""
  INSTALL_COMMAND ""
  BUILD_IN_SOURCE 1
)
ExternalProject_Add(extgc 
  DEPENDS libatomic_ops
  GIT_REPOSITORY git://github.com/robovm/bdwgc.git
  GIT_TAG 771fc48733c8a1a63fbc5720cc05fffe7a765117
  UPDATE_COMMAND ""
  PATCH_COMMAND bash -c "rm -rf libatomic_ops && ln -s ../../../libatomic_ops-prefix/src/libatomic_ops libatomic_ops"
  CONFIGURE_COMMAND bash -c "CC=${CMAKE_C_COMPILER} CFLAGS='${EXTGC_C_FLAGS}' LDFLAGS='${EXTGC_LD_FLAGS}' ./configure ${EXT_HOST} ${EXTGC_PARAMS} --prefix=${CMAKE_BINARY_DIR}/gc"
  BUILD_IN_SOURCE 1
)
install(FILES ${CMAKE_BINARY_DIR}/gc/lib/libgc.a DESTINATION ${INSTALL_DIR} RENAME libgc${LIB_SUFFIX})

add_subdirectory(core/src)
add_subdirectory(debug/src)
add_subdirectory(bc/src)
add_subdirectory(rt)
