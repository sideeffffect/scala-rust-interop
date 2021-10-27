use std::panic;

// This is the interface to the JVM that we'll call the majority of our
// methods on.
use jni::JNIEnv;
// These objects are what you should use as arguments to your native
// function. They carry extra lifetime information to prevent them escaping
// this context and getting used after being GC'd.
use jni::objects::JObject;
use jni::sys::jint;

// This keeps Rust from "mangling" the name and making it unique for this
// crate.
#[no_mangle]
pub extern "system" fn Java_com_github_sideeffffect_scalarustinterop_Adder_plus(
  env: JNIEnv,
  object: JObject,
  term: jint,
) -> jint {
  let result = panic::catch_unwind(|| {
    let base = env.get_field(object, "base", "I").unwrap().i().unwrap();
    println!("Printing from rust library. base: {}", base);
    println!("Printing from rust library. term: {}", term);
    base + term
  });
  result.unwrap_or_else(|e| {
    let description = e
      .downcast_ref::<String>()
      .map(|e| &**e)
      .or_else(|| e.downcast_ref::<&'static str>().copied())
      .unwrap_or("Unknown error in native code.");
    env.throw_new("java/lang/RuntimeException", description).unwrap();
    -1 // some value to satisfy type checker, it won't be used
  })
}
