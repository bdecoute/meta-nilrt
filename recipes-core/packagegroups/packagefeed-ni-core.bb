SUMMARY = "Package feed which contains all packages which are supported by NI."
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = "\
	packagegroup-base \
	packagegroup-core-boot \
	packagegroup-ni-base \
	packagegroup-ni-crio \
	packagegroup-ni-internal-deps \
	packagegroup-ni-nohz-kernel \
	packagegroup-ni-ptest \
	packagegroup-ni-restoremode \
	packagegroup-ni-runmode \
	packagegroup-ni-safemode \
	packagegroup-ni-transconf \
	packagegroup-ni-tzdata \
	packagegroup-ni-wifi \
	${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'packagegroup-core-x11', '', d)} \
	packagegroup-core-standalone-sdk-target \
	packagegroup-kernel-module-build \
	dkms \
"

RDEPENDS_${PN}_append_x64 = "\
	init-nilrt-ramfs \
	init-runmode-ramfs \
	rauc \
	rauc-mark-good \
	nilrt-grub-runmode \
	nilrt-grub-safemode \
	${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'packagegroup-ni-xfce', '', d)} \
"

# Required components for Veristand.
# Engineering contact: Marcelo Izaguirre
RDEPENDS_${PN}_append = "\
	libfmi \
"